
use pocketmine\item\Item;

class Lapis extends Solid{
	public function __construct(){
		parent::__construct(self::LAPIS_BLOCK, 0, "Lapis Block");
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
			default:
				return 15;
		}
	}

	public function getDrops(Item $item){
		if($item->isPickaxe() >= 3){
			return [
				[Item::LAPIS_BLOCK, 0, 1],
			];
		}else{
			return [];
		}
	}

}