import { Injectable } from '@nestjs/common';
import { CreateCompanyDto } from './dto/create-company.dto';
import { UpdateCompanyDto } from './dto/update-company.dto';
import { Company } from './entities/company.entity';
import { InjectRepository } from '@nestjs/typeorm';
import { Repository } from 'typeorm';

@Injectable()
export class CompanyService {
  constructor(
    @InjectRepository(Company) private serverRepository: Repository<Company>,
  ) {}
  create(createCompanyDto: CreateCompanyDto) {
    return this.serverRepository.create(createCompanyDto);
  }

  findAll() {
    return this.serverRepository.find();
  }

  findOne(company_code: string) {
    return this.serverRepository.findOne({ where: { company_code } });
  }

  update(company_code: string, updateCompanyDto: UpdateCompanyDto) {
    return this.serverRepository.update({ company_code }, updateCompanyDto);
  }

  remove(company_code: string) {
    return this.serverRepository.delete({ company_code });
  }
}
