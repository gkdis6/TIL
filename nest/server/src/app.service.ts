import { Injectable } from '@nestjs/common';
import configuration from './config/env/configuration';

@Injectable()
export class AppService {
  getStatus(): string {
    return `${configuration().app} is running`;
  }
}
