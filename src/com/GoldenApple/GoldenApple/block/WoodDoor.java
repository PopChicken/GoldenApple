
use pocketmine\item\Item;

class WoodDoor extends Door{
	public function __construct($meta = 0){
		parent::__construct(self::WOOD_DOOR_BLOCK, $meta, "Wood Door Block");
		$this->isActivable = true;
		$this->hardness = 15;
	}

	public function getDrops(Item $item){
		return [
			[Item::WOODEN_DOOR, 0, 1],
		];
	}
}