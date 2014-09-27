
use pocketmine\item\Item;

class Clay extends Solid{
	public function __construct(){
		parent::__construct(self::CLAY_BLOCK, 0, "Clay Block");
		$this->hardness = 3;
	}

	public function getDrops(Item $item){
		return [
			[Item::CLAY, 0, 4],
		];
	}
}