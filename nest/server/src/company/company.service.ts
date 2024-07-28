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
    return this.serverRepository.save(createCompanyDto);
  }

  findAll() {
    return this.serverRepository.find();
  }

  findOne(id: number) {
    return this.serverRepository.findOne({
      where: { id },
      relations: ['domain'],
    });
  }

  update(id: number, updateCompanyDto: UpdateCompanyDto) {
    return this.serverRepository.update({ id }, updateCompanyDto);
  }

  remove(id: number) {
    // this.serverRepository.manager.query()
    return this.serverRepository.delete({ id });
  }
}
