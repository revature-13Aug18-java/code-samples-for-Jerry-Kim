# Overview
What's Cooking allows you to explore and manage recipes. 
# Installation

`npm install`

`ng serve`

# features
 - Users can explore recipes by ingredients or recipe name
 - Users can register an account to save their favorite recipes
 - Users can browse chef recommended recipes 
 - Users can be of type `user` or `chef`. Saved recipes by chefs are public and can be accessed by any user by following the `recommended` link in the navbar. At present, users of type chef can be registered only by directly inserting one into the database, which requires access to the backend (lesoptimates.project2.backend)

# the code
This follows Angular 4 style and directory hierarchy. 
All sub components are in their own directories and directly attached to the root. Services are located outside. Models, which model the jsons returned from api calls, are in `models/`. This application also uses Angular routing, which is configured in its own module in the root directory. 

As for naming and other coding practices, we tried to keep things consistent. Dependencies are declared as the same as their class name but with lowercase first letter. `HttpRequests` are supposed to be done in services and returned as `Observable`. 

Occasionally (i.e. frequently) it and the data processing are contained entirely within the relevant component. Depends if we had time to change it. Links are generally, if not totally, to absolute path names (we do plan to change this). 
Variables may be typed or not. Again, depends if we had time. Concerning more complicated types - i.e. json in the http response - `any` was used mostly, but we did confirm a working version using one of the `models`.

We debugged with console logs (sorry) so those are found all over the place still. 

At present, urls are mostly hardcoded instead of global values. 

## Components
### Home (/home)
This is the entry point for users. It also serves as the redirection link for unknown urls

`index.html` contains the main template `app.component.html`, which renders a navbar (`nav/nav.component.html`) and the `router-outlet` initially set to render `home.component.html`.

### Nav
`NavComponent` displays links to different views that give change to the `<router-outlet>` entity below itself. It actively uses a few services from the getgo (`ngOnInit`). These services are the `SessionService` and the `RecipeService` (you'll see this one used a lot). The `SessionService` retrieves a session token from the server. If the response is anything other than a valid token (for example, `null`), the app assumes the user is not logged in. `RecipeService` retrieves a list of valid chefs, to be used as data to prepare the chefs recommended page.

It uses a few Angular directives to conditionally hide or modify certain links (for example, login, save). It uses one-way binding to retrieve user input into the search bar in order to use it as a query parameter to `food2fork`'s api. Instead of using a `routerLink` attribute, the submit button listens for a click event, which commands the `router` to navigate to the `SearchComponent` and pass along data, namely the query parameter. 

### Search
`SearchComponent` handles queries to the food2fork api. Search input is passed along as query parameters to the request url and must conform to food2fork api format since currently there is no handler for that. 

Inside `search.component.ts` there is code to trigger animations on the save button. This did not make it into the current iteration.

The api url is "https://www.food2fork.com/api/search?" and hard coded into the `HttpClient`s `get()` method. Api keys are also hardcoded and is the first query parameter. Keys are associated with our accounts on food2fork and have a limit of 50 requests per day. Query parameters gotten from the search input are appended as-is into the url and will depend on the user to format it correctly. The syntax is https://www.food2fork.com/api/search?q={key}&{ingredient1, ingredient2, …}


### Recommend & RecommendedDetails

The navbar displays a link to "Recommended", which routes the user to a list of chef users. These are linked to their own urls that display all recipes saved by that chef. If there are no recipes associated with a chef, the page displays as blank.


## Services
There are two services in use. `RecipeService` is meant to handle coordination between retrieving data from food2fork and retrieving data from our backend. Short story is, there were some git merge problems and a lot of the service's implementations were duplicated into the component where the service ought to have been injected. The `SessionService` manages http sessions - stored on our backend. 
# unused stuff
`chefs-repository.service.ts`

`foodcall.*`

`username.service.spec.ts`

`results:any[]` in `home/home.component.ts`
`popper.js` in `index.html`
# unfinished stuff

`error/*`

module to contain handling of `HttpErrorResponse` and bad links