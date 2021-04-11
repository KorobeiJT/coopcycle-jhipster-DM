import { IProduit } from 'app/shared/model/produit.model';
import { ICourse } from 'app/shared/model/course.model';
import { ICompte } from 'app/shared/model/compte.model';

export interface IPanier {
  id?: number;
  nbElements?: number;
  price?: number;
  produits?: IProduit[];
  course?: ICourse;
  compte?: ICompte;
}

export class Panier implements IPanier {
  constructor(
    public id?: number,
    public nbElements?: number,
    public price?: number,
    public produits?: IProduit[],
    public course?: ICourse,
    public compte?: ICompte
  ) {}
}
