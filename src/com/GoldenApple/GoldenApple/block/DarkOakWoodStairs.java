
use pocketmine\item\Item;

class DarkOakWoodStairs extends Stair{
	public function __construct($meta = 0){
		parent::__construct(self::DARK_OAK_WOOD_STAIRS, $meta, "Dark Oak Wood Stairs");
	}

	public function getDrops(Item $item){
		return [
			[$this->id, 0, 1],
		];
	}
}