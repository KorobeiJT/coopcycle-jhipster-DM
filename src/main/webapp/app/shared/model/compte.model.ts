import { ICourse } from 'app/shared/model/course.model';
import { IPanier } from 'app/shared/model/panier.model';
import { IRoles } from 'app/shared/model/roles.model';
import { ICooperative } from 'app/shared/model/cooperative.model';
import { IRestaurant } from 'app/shared/model/restaurant.model';
import { ISystemePaiement } from 'app/shared/model/systeme-paiement.model';

export interface ICompte {
  id?: number;
  name?: string;
  surname?: string;
  age?: number;
  accountid?: string;
  adress?: string;
  role?: string;
  course?: ICourse;
  paniers?: IPanier[];
  roles?: IRoles;
  cooperative?: ICooperative;
  restaurants?: IRestaurant[];
  systemePaiements?: ISystemePaiement[];
}

export class Compte implements ICompte {
  constructor(
    public id?: number,
    public name?: string,
    public surname?: string,
    public age?: number,
    public accountid?: string,
    public adress?: string,
    public role?: string,
    public course?: ICourse,
    public paniers?: IPanier[],
    public roles?: IRoles,
    public cooperative?: ICooperative,
    public restaurants?: IRestaurant[],
    public systemePaiements?: ISystemePaiement[]
  ) {}
}
