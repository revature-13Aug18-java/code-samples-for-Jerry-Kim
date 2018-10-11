import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Recipe } from '../models/Recipe';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FoodcallService {

  constructor(private http: HttpClient) { }
  foodUrl:string = "assets/recipe.json";

  //  getRecipeResponse() : Observable<Recipe> {
  //    return this.http.get('assets/recipe.json');
  //  }
}
