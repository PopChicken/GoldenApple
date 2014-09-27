
class AcaciaWoodStairs extends Stair{
	public function __construct($meta = 0){
		parent::__construct(self::ACACIA_WOOD_STAIRS, $meta, "Acacia Wood Stairs");
	}

	public function getDrops(Item $item){
		return [
			[$this->id, 0, 1],
		];
	}
}