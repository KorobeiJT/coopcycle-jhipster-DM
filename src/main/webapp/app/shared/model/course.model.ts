import { IPanier } from 'app/shared/model/panier.model';
import { ICompte } from 'app/shared/model/compte.model';
import { IRestaurant } from 'app/shared/model/restaurant.model';

export interface ICourse {
  id?: number;
  timeRequired?: number;
  panier?: IPanier;
  compte?: ICompte;
  restaurants?: IRestaurant[];
}

export class Course implements ICourse {
  constructor(
    public id?: number,
    public timeRequired?: number,
    public panier?: IPanier,
    public compte?: ICompte,
    public restaurants?: IRestaurant[]
  ) {}
}
