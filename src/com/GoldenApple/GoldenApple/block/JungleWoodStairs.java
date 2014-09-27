
use pocketmine\item\Item;

class JungleWoodStairs extends Stair{
	public function __construct($meta = 0){
		parent::__construct(self::JUNGLE_WOOD_STAIRS, $meta, "Jungle Wood Stairs");
	}

	public function getDrops(Item $item){
		return [
			[$this->id, 0, 1],
		];
	}
}