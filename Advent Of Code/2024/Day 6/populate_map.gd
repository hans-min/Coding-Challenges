extends TileMap

var guard_position = Vector2i()
var guard_direction = Vector2i()
var distance_walked: int = 1

func _ready():
	print("Map running")
	var input_map = get_map_input()
	for y in range(input_map.size()):
		for x in range(input_map[y].length()):
			var source_id: int = 0
			match input_map[y][x]:
				".":
					source_id = 0  # Empty space
				"#":
					source_id = 1  # Obstacle
				"^", ">", "<", "v":
					guard_position = Vector2i(x, y)
					source_id = 2
					get_guard_initial_direction(input_map[y][x])
			set_cell(0, Vector2i(x,y), source_id, Vector2i(0,0))

func get_map_input() -> Array[String]:
	var input: Array[String] = []
	var file = FileAccess.open("res://input.txt", FileAccess.READ)
	while !file.eof_reached():
		var line = file.get_line()
		if !line.is_empty():
			input.append(line)
	file.close()
	return input


func get_guard_initial_direction(input: String):
	match input:
		"^":
			guard_direction = Vector2i(0, -1)  # Up
		">":
			guard_direction = Vector2i(1, 0)  # Right
		"<":
			guard_direction = Vector2i(-1, 0)  # Left
		"v":
			guard_direction = Vector2i(0, 1)  # Down

func move_guard():
	var new_guard_position = guard_direction + guard_position
	if get_cell_source_id(0, new_guard_position) == 1:
		# Turn right if meet obstacle
		guard_direction = Vector2i(-guard_direction.y, guard_direction.x)
	elif get_cell_source_id(0, new_guard_position) == -1:
		print("game end")
		print(distance_walked)
		await get_tree().create_timer(0.1).timeout
		get_tree().quit()
	else:
		if get_cell_source_id(0, new_guard_position) == 0:
			# if it's a new empty cell that the guard haven't pass by, distance += 1
			distance_walked += 1
		guard_position = new_guard_position
		set_cell(0, guard_position, 2, Vector2i(0,0))

# Called every frame. 'delta' is the elapsed time since the previous frame.
func _process(delta):
	move_guard()
