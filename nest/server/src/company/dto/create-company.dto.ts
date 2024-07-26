import { IsDate, IsNotEmpty, IsString } from 'class-validator';
import { ApiProperty, ApiPropertyOptional } from '@nestjs/swagger';

export class CreateCompanyDto {
  @IsNotEmpty()
  @IsString()
  @ApiProperty()
  // @ApiProperty({ example: '' })
  company_code: string;

  @IsNotEmpty()
  @IsString()
  @ApiPropertyOptional()
  // @ApiPropertyOptional({ example: '' })
  company_name: string;

  @IsString()
  @ApiPropertyOptional()
  use_space: string;

  @IsString()
  @ApiPropertyOptional()
  work_space: string;

  @IsString()
  @ApiPropertyOptional()
  memo: string;

  @IsString()
  @ApiPropertyOptional()
  credential_memo: string;

  @IsDate()
  @ApiPropertyOptional({ example: '2024-07-24' })
  update_date: Date;
}
