
use pocketmine\item\Item;

class CoalOre extends Solid{
	public function __construct(){
		parent::__construct(self::COAL_ORE, 0, "Coal Ore");
		$this->hardness = 15;
	}

	public function getBreakTime(Item $item){
		switch($item->isPickaxe()){
			case 5:
				return 0.6;
			case 4:
				return 0.75;
			case 3:
				return 1.15;
			case 2:
				return 0.4;
			case 1:
				return 2.25;
			default:
				return 15;
		}
	}

	public function getDrops(Item $item){
		if($item->isPickaxe() >= 1){
			return [
				[Item::COAL, 0, 1],
			];
		}else{
			return [];
		}
	}

}