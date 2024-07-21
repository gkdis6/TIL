import { IsDate, IsEmpty, IsNotEmpty, IsString, IsUrl } from 'class-validator';

export class CreateServerDto {
  @IsNotEmpty()
  @IsString()
  name: string;

  @IsNotEmpty()
  @IsString()
  @IsUrl()
  domain: string;

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
