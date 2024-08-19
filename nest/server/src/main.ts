import { NestFactory } from '@nestjs/core';
import { AppModule } from './app.module';
import { BadRequestException, ValidationPipe } from '@nestjs/common';
import { DocumentBuilder, SwaggerModule } from '@nestjs/swagger';
import Configuration from './config/env/configuration';
import expressBasicAuth from 'express-basic-auth';

const createGlobalPipes = () => {
  return new ValidationPipe({
    whitelist: true,
    transform: true,
    transformOptions: {
      enableImplicitConversion: true,
    },
    exceptionFactory: (errors) => {
      console.error('Validation errors:', errors);
      return new BadRequestException('Validation failed');
    },
  });
};

const setupSwagger = (app) => {
  const config = new DocumentBuilder()
    .setTitle(`${Configuration().app} API Docs`)
    .setDescription(`${Configuration().app} api 문서입니다.`)
    .setVersion('1.0')
    .build();
  const document = SwaggerModule.createDocument(app, config);
  SwaggerModule.setup('docs', app, document);

  app.use(
    ['/docs'],
    expressBasicAuth({
      challenge: true,
      users: {
        [Configuration().swagger.user]: Configuration().swagger.password,
      },
    }),
  );
};

async function bootstrap() {
  const app = await NestFactory.create(AppModule);

  app.useGlobalPipes(createGlobalPipes());
  app.enableCors();
  setupSwagger(app);
  await app.listen(Configuration().port);
}
bootstrap();
