import {
  BaseEntity,
  Column,
  Entity,
  JoinColumn,
  ManyToOne,
  PrimaryGeneratedColumn,
} from 'typeorm';
import { Company } from '../../company/entities/company.entity';

@Entity('server')
export class Server extends BaseEntity {
  @PrimaryGeneratedColumn()
  srno: number;

  @Column({ type: 'varchar', comment: '서버 ID', unique: true })
  server_id: string;

  @Column({ type: 'varchar', comment: '서버 타입(DEV/STG/PROD)' })
  server_type: string;

  @Column({ type: 'varchar', comment: '접속 세션' })
  session_id: string;

  @Column({ type: 'varchar', comment: '서버별 도메인 주소' })
  server_domain: string;

  @Column({ type: 'varchar', comment: 'NAS 경로' })
  nas_path: string;

  @Column({ type: 'varchar', comment: 'IP 주소' })
  ip: string;

  @ManyToOne(() => Company, (company) => company.server, {
    onDelete: 'CASCADE',
    onUpdate: 'CASCADE',
  })
  @JoinColumn({ name: 'company_code', referencedColumnName: 'company_code' })
  company_code: Company;
}
