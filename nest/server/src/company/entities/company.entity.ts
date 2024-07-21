import {
  BaseEntity,
  Column,
  Entity,
  OneToMany,
  PrimaryGeneratedColumn,
} from 'typeorm';
import { Server } from '../../server/entities/server.entity';

@Entity('company')
export class Company extends BaseEntity {
  @PrimaryGeneratedColumn()
  srno: number;

  @Column({ type: 'varchar', comment: '회사코드', unique: true })
  company_code: string;

  @Column({ type: 'varchar', comment: '회사명' })
  company_name: string;

  @Column({ type: 'varchar', comment: '대표 도메인 주소' })
  company_domain: string;

  @Column({ type: 'text', comment: '사용환경' })
  use_space: string;

  @Column({ type: 'text', comment: '작업환경' })
  work_space: string;

  @Column({ type: 'text', comment: '참고' })
  memo: string;

  @Column({ type: 'text', comment: '계정정보 메모' })
  credential_memo: string;

  @Column({ type: 'date', comment: 'SSL 교체 시기' })
  ssl_due_date: Date;

  @Column({ type: 'date', comment: '최근 업데이트일' })
  update_date: Date;

  @OneToMany(() => Server, (server) => server.company_code)
  server: Server[];
}
