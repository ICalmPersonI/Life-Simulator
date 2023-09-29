# Life Simulator

This is an Android application that implements the classic game of "Life" with the ability to customize various game parameters. The game allows you to change the game rules, neighbor checking type, game speed, game board size, and save your progress when exiting the app. Additionally, you can interact with the game board manually by adding live cells.

## Key Features

1. **Customizable Game Rules**: The app lets you configure the game rules, including the type of neighbor checking (e.g., classic or with special rules).
2. **Game Speed**: You can adjust the game speed to generate new generations faster or slower.
3. **Game Board Size**: Modify the game board size according to your preferences by selecting the number of rows and columns.
4. **Progress Saving**: The app automatically saves your progress, so you can resume your game later.
5. **Manual Interaction with the Game Board**: In addition to automatic cell generation, you can manually add cells on the game board by tapping on them.
6. **Cell Color Based on Age**: The color of each cell depends on its age, starting from green for the youngest cells.
7. **Cyclic Game Board**: The game board is cyclic and has no boundaries, meaning cells on the edges wrap around to the opposite side.



Screenshots
---------------
<img src="https://github.com/ICalmPersonI/Life-Simulator/assets/87424785/fa68c441-d7b4-4633-8f5e-3aab09ae7e4b" alt="1" width="180" height="300">
<img src="https://github.com/ICalmPersonI/Life-Simulator/assets/87424785/86ce068b-8849-4c93-90f8-d83da4425235" alt="2" width="180" height="300">
<img src="https://github.com/ICalmPersonI/Life-Simulator/assets/87424785/b0ed88ea-6385-474c-93fb-216b465b1b15" alt="3" width="180" height="300">

Tech Stack
---------------
- Minimum SDK level 24
- [Jetpack Compose](https://developer.android.com/jetpack/compose)
- [Dagger2](https://dagger.dev)
- [Kotlin Flows](https://developer.android.com/kotlin/flow)
- [Gson](https://github.com/google/gson)

