import { IsEmpty, IsNotEmpty, IsString, IsUrl } from 'class-validator';

export class CreateServerDto {
  @IsNotEmpty()
  @IsString()
  server_id: string;

  @IsNotEmpty()
  @IsString()
  server_type: string;

  @IsNotEmpty()
  @IsString()
  session_id: string;

  @IsNotEmpty()
  @IsString()
  @IsUrl()
  server_domain: string;

  @IsEmpty()
  @IsString()
  nas_path: string;

  @IsEmpty()
  @IsString()
  ip: string;

  @IsEmpty()
  @IsString()
  company_code: string;
}
