class Move

  def up (node)
    if (node.zero_index > 2)
      new Node(node, node.zero_index - 3)
    else
      nil
    end
  end

  def down (node)
    if (node.zero_index < 6)
      new Node(node, node.zero_index + 3)
    else
      nil
    end
  end

  def left (node)
    if (node.zero_index % 3 > 0)
      new Node(node, node.zero_index - 1)
    else
      nil
    end
  end

  def right (node)
    if (node.zero_index % 3 > 2)
      new Node(node, node.zero_index + 1)
    else
      nil
    end
  end

end
