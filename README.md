# Jeddah Event Queue Management System

This project simulates a queue management system for an event, managing visitors entering main queues, moving them to auditoriums, and handling ticketing using stacks.

## Features

### Main Functionalities

1. **Enter**: Adds a visitor to the main queue.
2. **Serve**: Moves visitors from the main queue to either auditorium#1 or auditorium#2 based on their chosen show.
3. **Start**: Processes the visitors by moving them from auditoriums to stacks for ticket management.
4. **Print**: Displays the ticket numbers for visitors in each auditorium stack.

### Data Structures Used

- **Queue**: Manages visitors in the main queue and auditoriums.
- **Stack**: Manages ticket numbers for each auditorium.

## Code Explanation

### Main Class

- The `Main` class manages reading input from a file and processing commands.
- Different commands (Enter, Serve, Start, Print) are handled in a loop.
- Visitors are moved between queues and stacks based on the commands.
  
### Classes

- **Visitor**: Represents a visitor with a first name, last name, chosen show, ticket number, and other details.
- **Queue**: Manages the queue operations (enqueue, dequeue, isEmpty, isFull).
- **Stack**: Manages the stack operations (push, pop, size).

## How to Use

1. Ensure that `input.txt` and `output.txt` files are available in the project directory.
2. Run the Java program. It reads from `input.txt` and outputs the results to `output.txt`.

### Input File (`input.txt`)

- Contains commands to manage the event system:
  - Enter <firstName> <lastName> <showName>
  - Serve
  - Start
  - Print

### Output File (`output.txt`)

- Logs the results of each command and shows the ticket numbers for each auditorium.

## Example Commands in Input File

1. `Enter John Doe show#1`
2. `Serve`
3. `Start`
4. `Print`

## Notes

- Ensure that necessary classes (`QueueOfVisitorLL`, `QueueOfAuditoriumArr`, `StackOfTN`, `Visitor`) are properly implemented.
- Adjust queue and stack sizes as needed for larger events.

