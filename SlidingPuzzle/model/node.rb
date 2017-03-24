class Node

  def initialize(args)
    if args.size == 1
      @list_of_numbers = Array.new
      @list_of_numbers = args
      @zero_index = get_zero_index(args)
      @previous = nil
      @number_of_moves = 0;
      @moves_to_the_goal = Program.get_path(@list_of_numbers);
    else
      previous = args[0]
      zero_index = args[1]
      @list_of_numbers = previous.list_of_numbers
      @list_of_numbers[previous.zero_index] = @list_of_numbers[zero_index]
      @list_of_numbers[zero_index] = 0;
      @zero_index = zero_index
      @number_of_moves = previous.number_of_moves+1
      @moves_to_the_goal = Puzzle.get_path(@list_of_numbers)
      @previous = previous
    end
  end

  def get_zero_index(numbers)
    zero_index = numbers.index(0)
    zero_index
  end
end
