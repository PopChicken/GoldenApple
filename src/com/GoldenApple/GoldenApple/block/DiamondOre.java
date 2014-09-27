
use pocketmine\item\Item;

class DiamondOre extends Solid{
	public function __construct(){
		parent::__construct(self::DIAMOND_ORE, 0, "Diamond Ore");
		$this->hardness = 15;
	}

	public function getBreakTime(Item $item){
		switch($item->isPickaxe()){
			case 5:
				return 0.6;
			case 4:
				return 0.75;
			default:
				return 15;
		}
	}

	public function getDrops(Item $item){
		if($item->isPickaxe() >= 4){
			return [
				[Item::DIAMOND, 0, 1],
			];
		}else{
			return [];
		}
	}
}