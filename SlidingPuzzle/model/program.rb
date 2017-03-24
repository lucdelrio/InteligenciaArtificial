require 'thread'
require_relative '../model/move'

class Program

  attr_reader :solution
  attr_accessor :input_node
  attr_accessor :list_of_numbers
  attr_accessor :visitado
  attr_accessor :nodos
  attr_accessor :current_node

  def initialize
    @solution = [0,1,2,3,4,5,6,7,8]
    @input_node = Array.new
    @current_node = Array.new
    @visited = Array.new
    @nodos = Array.new
  end

  def is_solution?(list_of_numbers)
    @solution == list_of_numbers
  end

  def input_to_list (string)
    @input_node = string.split(",").map { |s| s.to_i }
  end

  def get_path (list)
    path = 0
    for i in(0..list.length)
      if i != 0
        path += path_distance(index, list[i])
      end
    end
    path
  end

  def path_distance (index, number)
    result = Math.abs((index/3)-((number-1)/3))+Math.abs((index %3)-((number-1)%3))
    result
  end

  def solve_puzzle
    @nodos.clear
    @nodos.push @input_node
    while @nodos.length > 0
      @current_node = @nodos.shift

      if @current_node == @solution
        print @current_node
      end
      @visited.push @current_node

      @nodos.add_to_queue (Move.up @current_node)
      @nodos.add_to_queue (Move.down @current_node)
      @nodos.add_to_queue (Move.left @current_node)
      @nodos.add_to_queue (Move.right @current_node)
    end
  end

  def add_to_queue (next_node)
    contains = false
    @visited.each do |visided_nodes|
      if visided_nodes.include? next_node
        contains = true
      end
    end
    if (next_node != nil && !contains)
      @nodos.push next_node
    end
  end

end
