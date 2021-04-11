import { ICompte } from 'app/shared/model/compte.model';

export interface IRoles {
  id?: number;
  role?: string;
  comptes?: ICompte[];
}

export class Roles implements IRoles {
  constructor(public id?: number, public role?: string, public comptes?: ICompte[]) {}
}
