# UnoWarMatch

## Overview

This repo contains the game of "UnoWarMatch", which is a mixture of the popular game Uno, and War. However, instead of being a game played against other players, this program focuses on testing several simple AIs against each other (and itself). Each of the AIs has their respective strategies to play the game, thus the AI who has the highest winrate would indicate that its strategy would work best. 

## The AIs' Strategy 

While there are theoretically infinite possible strategies, 3 simple strategies would only be tested.

### Basic AI 

The basic AI will be a “baseline” – this means it is not expected to perform well, but it will be useful to compare against. This basic AI will play the first random valid card in their hand each turn.  Since this AI has no real “strategy” – any AI that does better than it can be said to have a good strategy, and any AI that does worse can be said to have bad strategy (worse than not trying!)

### Second AI

The second AI will always play the smallest-ranked valid card in their hand. This strategy is designed to give the player the most options in the future. As a downside – however, this conservative strategy also leaves the most options open to the opponent, and tends to lead to longer games.

### Third AI

The third AI will always play the highest-ranked valid card in their hand. This strategy is designed to force decisive victories by limiting their opponents choices. This tends to lead to fast games – Playing your strongest card can backfire if the opponent has stronger cards than you!

## Game Rules

The card game is a rough mix of Uno and War. The game is played with a standard deck of cards. Each player has a 5 card hand, and draws from the same deck of cards. After a player plays a card they always draw a replacement (so hands always have 5 cards) and if the deck is ever empty – it is immediately re-shuffled (so the players can always draw another
card). The game is simualted so that if each time the deck is empty we open and shuffle a new 52 card deck of cards.

The game of Unowar is structured into rounds. Each round players play until someone loses the round – the other player (that rounds winner) gets one point. The winner then has to go first the next round (first round is normally given to “player 1” – chosen before the game begins) Rounds are played back-to-back, so players keep their hands between rounds, and making sure you save good cards for later rounds is a deliberate part of the strategy of the game. The game is over when
one player has 10 points (wins 10 total rounds).

A single round of Unowar starts by dealing one card from the deck and placing it in the “card pile” between the two players. Then players take turns playing a card into the card pile from their hand. Cards can only be played if they meet one or both of the following conditions:

(1) same suit as the card in the middle (suit is the symbol on the card: clubs, spades, diamonds,
or hearts)
(2) equal or higher rank than the card in the middle (rank is the number of the card: aces, twos,
and threes are low, 10, jacks, queens, and kings are high, and so-forth.)

If a player plays a card that does not meet one or both requirements then that player loses the round. If a player does not have any cards that they can play, they also lose the round. Players keep going this way until the current player can’t play – meaning they lose. In theory a single round can last quite a long time with the right cards. Regardless of who wins/loses, the card pile is discarded at the end of the round (As a new card pile will be started in the next round with a new card from the deck).

So a game of uno war would look like this:
1. Shuffle the deck of cards
2. Deal two 5-card hands two player 1 and player 2
3. Player 1 plays first in the first round
4. while no player has won 10 rounds play one round:
(a) deal a card to start the card pile in the middle
(b) Starting with player 1 in the first round, or whoever won the last round in all other rounds, players take turns picking who goes first.
(c) if a player has no legal cards, that player loses the round, and the other player wins. The other player will have to go first next round.
(d) Discard the card pile in the middle.
5. Whoever won 10 rounds is the winner of the game
