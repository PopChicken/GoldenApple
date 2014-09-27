
use pocketmine\item\Item;

class Glass extends Transparent{
	public function __construct(){
		parent::__construct(self::GLASS, 0, "Glass");
		$this->hardness = 1.5;
	}

	public function getDrops(Item $item){
		return [];
	}
}