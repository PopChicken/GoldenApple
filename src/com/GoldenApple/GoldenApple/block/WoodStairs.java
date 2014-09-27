
use pocketmine\item\Item;

class WoodStairs extends Stair{
	public function __construct($meta = 0){
		parent::__construct(self::WOOD_STAIRS, $meta, "Wood Stairs");
	}

	public function getBreakTime(Item $item){

		switch($item->isAxe()){
			case 5:
				return 0.4;
			case 4:
				return 0.5;
			case 3:
				return 0.75;
			case 2:
				return 0.25;
			case 1:
				return 1.5;
			default:
				return 3;
		}
	}

	public function getDrops(Item $item){
		return [
			[$this->id, 0, 1],
		];
	}
}