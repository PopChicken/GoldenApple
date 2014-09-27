
use pocketmine\item\Item;

class Bedrock extends Solid{
	public function __construct(){
		parent::__construct(self::BEDROCK, 0, "Bedrock");
		$this->breakable = false;
		$this->hardness = 18000000;
	}

	public function isBreakable(Item $item){
		return false;
	}

}