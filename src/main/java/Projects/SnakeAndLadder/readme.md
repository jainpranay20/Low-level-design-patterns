Problem: Design Snake and Ladder Game (LLD)
Goal

Design a Snake and Ladder game for 2 players.

Classes to design (ONLY 4)

Game

Board

Player

Dice

(No extra classes like Snake or Ladder — keep it beginner-LLD level)

Step-by-step Questions
Q1. Dice

What should a Dice do?

How many faces?

What method is required?

roll() → returns number between 1–6

👉 Dice should have no game logic.

Q2. Player

What attributes does a Player need?

name

currentPosition

What methods are required?

move(int steps)

getPosition()

👉 Player does not know about snakes or ladders.

Q3. Board

What should Board contain?

size (1–100)

snakes & ladders mapping (start → end)

How to represent snakes & ladders?

Map<Integer, Integer>

What method is needed?

getFinalPosition(int position)

👉 Board decides if a player hits snake or ladder.

Q4. Game (main controller)

What does Game manage?

Board

Dice

Players

What methods should it have?

start()

playTurn(Player player)

Who checks win condition?

Game, not Player

👉 Game controls flow, not rules inside Player.

Game Rules (simple)

Board size = 100

Player starts at position 0

If position > 100 → ignore move

If player reaches exactly 100 → wins

Snake/Ladder applied after move

Thinking Check (Interview Gold ⭐)

Why Board owns snakes & ladders?

Why Game owns turn logic?

Why Player is kept dumb?