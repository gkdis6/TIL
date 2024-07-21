import { TypeOrmModuleOptions, TypeOrmOptionsFactory } from '@nestjs/typeorm';
import { Injectable } from '@nestjs/common';
import Configuration from './env/configuration';

@Injectable()
export class TypeormConfig implements TypeOrmOptionsFactory {
  createTypeOrmOptions(): TypeOrmModuleOptions {
    return {
      type: 'postgres', // TODO: 데이터베이스 종류
      // url: '', // TODO: ex) postgresql://username:password@hostname:port/database
      host: Configuration().database.host, // TODO: 데이터베이스 서버 호스트
      port: Configuration().database.port, // TODO: 데이터베이스 포트
      username: Configuration().database.user,
      password: Configuration().database.password,
      database: Configuration().database.database, // TODO: 연결할 데이터베이스 이름
      synchronize: Configuration().database.syncronize, // TODO: 스키마 자동 동기화 (production에서는 false)
      dropSchema: false, // TODO: 애플리케이션 실행시 기존 스키마 삭제 여부
      keepConnectionAlive: true, // TODO: 애플리케이션 재시작 시 연결 유지
      logging: ['query', 'error', 'schema'], // TODO: 데이터베이스 쿼리 로깅 여부
      entities: [__dirname + '/../**/*.entity.{js,ts}'], //TODO: 중요! 엔티티 클래스 경로
      extra: {
        max: 100,
      },
      // poolSize: 100,
    } as TypeOrmModuleOptions;
  }
}
