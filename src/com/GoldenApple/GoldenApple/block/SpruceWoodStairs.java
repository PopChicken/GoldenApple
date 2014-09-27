
use pocketmine\item\Item;

class SpruceWoodStairs extends Stair{
	public function __construct($meta = 0){
		parent::__construct(self::SPRUCE_WOOD_STAIRS, $meta, "Spruce Wood Stairs");
	}

	public function getDrops(Item $item){
		return [
			[$this->id, 0, 1],
		];
	}
}