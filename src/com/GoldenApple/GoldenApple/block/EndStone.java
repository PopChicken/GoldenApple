
use pocketmine\item\Item;

class EndStone extends Solid{
	public function __construct(){
		parent::__construct(self::END_STONE, 0, "End Stone");	
		$this->hardness = 45;
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
}