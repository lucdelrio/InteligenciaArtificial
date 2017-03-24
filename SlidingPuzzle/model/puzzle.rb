require_relative '../model/program'
require_relative '../model/move'
require_relative '../model/node'

class Main

  @program = Program.new
  @program.input_to_list(ARGV[0])
  @program.solve_puzzle

end
