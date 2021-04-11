import { ICompte } from 'app/shared/model/compte.model';
import { IRestaurant } from 'app/shared/model/restaurant.model';

export interface ICooperative {
  id?: number;
  name?: string;
  members?: string;
  comptes?: ICompte[];
  restaurants?: IRestaurant[];
}

export class Cooperative implements ICooperative {
  constructor(
    public id?: number,
    public name?: string,
    public members?: string,
    public comptes?: ICompte[],
    public restaurants?: IRestaurant[]
  ) {}
}
