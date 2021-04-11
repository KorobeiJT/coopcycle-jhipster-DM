import { ICompte } from 'app/shared/model/compte.model';

export interface ISystemePaiement {
  id?: number;
  crediteur?: string;
  debiteur?: string;
  method?: string;
  comptes?: ICompte[];
}

export class SystemePaiement implements ISystemePaiement {
  constructor(
    public id?: number,
    public crediteur?: string,
    public debiteur?: string,
    public method?: string,
    public comptes?: ICompte[]
  ) {}
}
