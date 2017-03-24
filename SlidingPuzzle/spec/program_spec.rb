require 'rspec'
require_relative '../model/puzzle'
require_relative '../model/program'

describe 'Program' do

  it 'pass input_to_list' do
    program = Program.new
    expect(program.input_to_list("1,0,5,6,4,7,2,3,8")).to match_array(program.input_node)
  end

  it 'solution equals to list_of_numbers' do
    program = Program.new
    expect(program.is_solution?([0,1,2,3,4,5,6,7,8])).to eq true
  end


end
