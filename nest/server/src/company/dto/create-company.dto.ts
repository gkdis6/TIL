import { IsDate, IsEmpty, IsNotEmpty, IsString, IsUrl } from 'class-validator';

export class CreateCompanyDto {
  @IsNotEmpty()
  @IsString()
  company_code: string;

  @IsNotEmpty()
  @IsString()
  company_name: string;

  @IsNotEmpty()
  @IsString()
  @IsUrl()
  company_domain: string;

  @IsEmpty()
  @IsString()
  use_space: string;

  @IsEmpty()
  @IsString()
  work_space: string;

  @IsEmpty()
  @IsString()
  memo: string;

  @IsEmpty()
  @IsString()
  credential_memo: string;

  @IsDate()
  ssl_due_date: Date;

  @IsDate()
  update_date: Date;
}
