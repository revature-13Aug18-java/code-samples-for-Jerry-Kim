import { Component, OnInit } from '@angular/core';
/*
count: Number of recipes in result (Max 30)
recipes: List of Recipe Parameters ->
  image_url: URL of the image
  source_url: Original Url of the recipe on the publisher's site
  f2f_url: Url of the recipe on Food2Fork.com
  title: Title of the recipe
  publisher: Name of the Publisher
  publisher_url: Base url of the publisher
  social_rank: The Social Ranking of the Recipe (As determined by our Ranking Algorithm)
  page: The page number that is being returned (To keep track of concurrent requests)
  f2f_url: "http://food2fork.com/view/35382"
  image_url: "http://static.food2fork.com/Jalapeno2BPopper2BGrilled2BCheese2BSandwich2B12B500fd186186.jpg"
  publisher: "Closet Cooking"
  publisher_url: "http://closetcooking.com"
  recipe_id: "35382"
  social_rank: 100
  source_url: "http://www.closetcooking.com/2011/04/jalapeno-popper-grilled-cheese-sandwich.html"
  title: "Jalapeno Popper Grilled Cheese Sandwich"

 */

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  constructor() { }
  results = {
    "count": "30",
    "recipes":
    [
      {
  "f2f_url": "http://food2fork.com/view/35382",
  "image_url": "http://static.food2fork.com/Jalapeno2BPopper2BGrilled2BCheese2BSandwich2B12B500fd186186.jpg",
  "publisher": "Closet Cooking",
  "publisher_url": "http://closetcooking.com",
  "recipe_id": "35382",
  "social_rank": 100,
  "source_url": "http://www.closetcooking.com/2011/04/jalapeno-popper-grilled-cheese-sandwich.html",
  "title": "Jalapeno Popper Grilled Cheese Sandwich"
      }
    ]
  }
  ngOnInit() {
  }

}
