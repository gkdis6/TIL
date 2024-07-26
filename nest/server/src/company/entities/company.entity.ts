import {
  Column,
  Entity,
  PrimaryGeneratedColumn,
  CreateDateColumn,
  UpdateDateColumn,
} from 'typeorm';
import { ApiProperty, ApiPropertyOptional } from '@nestjs/swagger';

@Entity('company')
export class Company {
  @PrimaryGeneratedColumn()
  @ApiProperty()
  id: number;

  @Column({ type: 'varchar', comment: '회사코드', unique: true })
  @ApiProperty({ description: '회사코드' })
  company_code: string;

  @Column({ type: 'varchar', comment: '회사명' })
  @ApiPropertyOptional({ description: '회사명' })
  company_name: string;

  @Column({ type: 'text', comment: '사용환경' })
  @ApiPropertyOptional({ description: '사용환경' })
  use_space: string;

  @Column({ type: 'text', comment: '작업환경' })
  @ApiPropertyOptional({ description: '작업환경' })
  work_space: string;

  @Column({ type: 'text', comment: '참고' })
  @ApiPropertyOptional({ description: '참고' })
  memo: string;

  @Column({ type: 'text', comment: '계정정보 메모' })
  @ApiPropertyOptional({ description: '계정정보 메모' })
  credential_memo: string;

  @Column({ type: 'date', comment: '최근 업데이트일' })
  @ApiPropertyOptional({ description: '최근 업데이트일' })
  update_date: Date;

  @CreateDateColumn({ name: 'created_at' })
  @ApiPropertyOptional({ description: 'created_at' })
  created_at: Date;

  @UpdateDateColumn({ name: 'updated_at' })
  @ApiPropertyOptional({ description: 'updated_at' })
  updated_at: Date;
}
