

class Wood2 extends Wood{

	public function __construct($meta = 0){
		Solid::__construct(self::WOOD2, $meta, "Wood");
		$names = [
			0 => "Acacia Wood",
			1 => "Dark Oak Wood"
		];
		$this->name = $names[$this->meta & 0x03];
		$this->hardness = 10;
	}
}