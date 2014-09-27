
use pocketmine\item\Item;

class BirchWoodStairs extends Stair{
	public function __construct($meta = 0){
		parent::__construct(self::BIRCH_WOOD_STAIRS, $meta, "Birch Wood Stairs");
	}

	public function getDrops(Item $item){
		return [
			[$this->id, 0, 1],
		];
	}
}