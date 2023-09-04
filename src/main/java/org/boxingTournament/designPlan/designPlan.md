### Design Plan
- What are the classes/enums
- Enums
    - Match Status
        - Description
            - hold the status of each match
    - player level
        - Description
            - hold the level of each player in respect to the tournament
   - Tournament status
- Classes
    - Boxer
        - Description
            - This class should hold the specifics and logic for holding their record
        - Attributes
            - id
            - full name
            - weight
            - height
            - record
            - age
            - tournament level
        - Behavior
            - updating their record
            - updating their progression in the tournament
            - showing the information of the boxer
    - BoxingRecord
        - Description
            - Hold all the record of each player and the math to update it
        - Attributes
            - wins
            - losses
            - draws
        - Behaviors
            - AddWin
            - AddLoss
            - AddDraw
    - Tournament
        - Description
            - This class will manage the tournament structure.
              It will have multiple rounds and conferences and levels
              It will interact with the match class to further the opponents
              against each other
        - Attributes
            - A side of the tournament
            - B side of the tournament
            - NumberOfActiveParticipants
        - Behavior
            - Advance a fighter to the next level of the round
            - Eliminate a fighter off of the tournament structure
            - if there is a tie, they have to fight again
            - Run the next round (level) of tournament
    - ConferenceAbstractClass
        - Description
            - hold the common structure of each conference
        - AbstractMethods
            - weight division
            - look up boxer by id
    - Conference
        - Description
            - This class holds the 16 fighters for each side.
              able to look up fighters by id (going to use a sorting algorithm)
    - Match
        - Description
            - Define a match to represent individual matches.
              Store info about the match, and the logic for each match.
              Also generates which fighter won which round, and update the boxers
              record.
        - Attributes
            - Round
            - ScoreCards
            - PlayerA
            - PlayerB
            - Winner
            - Loser
            - StatusOfMatch
        - Behaviors
            - Call fighters to fight
            - judge who won, who loss or if it's a draw
            - update loss for loser
            - update winner for winner
            - update tournament class on who won and who loss
            - match result to the statistics class for export
    - StatisticsAndScoring
        - Description
            - Implement a scoring system to determine match outcomes,
              calculate rankings, and declare winners. Display these statistics
              in the console.
        - Behavior
            - Generate a round between two fighters
            - Calculate Rankings for fighters
            - add match results to a text file
    