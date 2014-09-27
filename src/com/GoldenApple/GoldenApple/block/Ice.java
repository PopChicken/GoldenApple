
use pocketmine\item\Item;

class Ice extends Transparent{
	public function __construct(){
		parent::__construct(self::ICE, 0, "Ice");
		$this->hardness = 2.5;
	}

	public function onBreak(Item $item){
		$this->getLevel()->setBlock($this, new Water(), true);

		return true;
	}

	public function getBreakTime(Item $item){
		switch($item->isPickaxe()){
			case 5:
				return 0.1;
			case 4:
				return 0.15;
			case 3:
				return 0.2;
			case 2:
				return 0.1;
			case 1:
				return 0.4;
			default:
				return 0.75;
		}
	}

	public function getDrops(Item $item){
		return [];
	}
}