# SoccerLeagueOrganizer
------
Task : Imagine that, we want to organize a soccer league in a company. To manage league matches,
we want to develop an android application. This application will be used to determine match
fixture and needs to have below functionalities;
1. Query team names from Web Service by REST API,
2. Determine fixture for 2 half of league matches,
3. Show team list and draw fixture button on the main screen of an application,
4. After a user click to Draw Fixture button, show each week matches on swipeable UI


## Technologies
------
- Mvvm archtitecture
- RecyclerView 
- Fragments
- ViewPager for swipeable ui
- Dagger Hilt for dependency injection
- Coroutines for asynchronous operations
- Retrofit and OkHttp for network operations
- Room DB for to store created fixture

### Extras
------
- Supporting dark mode
- Animations added for both when passing from team list screen to first-week match fixture and viewpager
- Signed apk location : /app/release/app-release.apk
