

class Planks extends Solid{
	const OAK = 0;
	const SPRUCE = 1;
	const BIRCH = 2;
	const JUNGLE = 3;
	const ACACIA = 4;
	const DARK_OAK = 5;

	public function __construct($meta = 0){
		parent::__construct(self::PLANKS, $meta, "Wood Planks");
		$names = [
			self::OAK => "Oak Wood Planks",
			self::SPRUCE => "Spruce Wood Planks",
			self::BIRCH => "Birch Wood Planks",
			self::JUNGLE => "Jungle Wood Planks",
			self::ACACIA => "Acacia Wood Planks",
			self::DARK_OAK => "Jungle Wood Planks",
		];
		$this->name = $names[$this->meta & 0x07];
		$this->hardness = 15;
	}

}