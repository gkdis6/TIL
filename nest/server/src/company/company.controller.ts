import {
  Controller,
  Get,
  Post,
  Body,
  Patch,
  Param,
  Delete,
} from '@nestjs/common';
import { CompanyService } from './company.service';
import { CreateCompanyDto } from './dto/create-company.dto';
import { UpdateCompanyDto } from './dto/update-company.dto';
import { ApiCreatedResponse, ApiOperation, ApiTags } from '@nestjs/swagger';
import { Company } from './entities/company.entity';

@Controller('company')
@ApiTags('회사 API')
export class CompanyController {
  constructor(private readonly companyService: CompanyService) {}

  @Post()
  @ApiOperation({ summary: '회사 생성 API', description: '회사를 생성한다.' })
  @ApiCreatedResponse({
    description: '회사를 생성한다.',
    type: Company,
  })
  create(@Body() createCompanyDto: CreateCompanyDto) {
    return this.companyService.create(createCompanyDto);
  }

  @Get()
  findAll() {
    return this.companyService.findAll();
  }

  @Get(':company_code')
  findOne(@Param('company_code') company_code: string) {
    return this.companyService.findOne(company_code);
  }

  @Patch(':company_code')
  update(
    @Param('company_code') company_code: string,
    @Body() updateCompanyDto: UpdateCompanyDto,
  ) {
    return this.companyService.update(company_code, updateCompanyDto);
  }

  @Delete(':company_code')
  remove(@Param('company_code') company_code: string) {
    return this.companyService.remove(company_code);
  }
}
