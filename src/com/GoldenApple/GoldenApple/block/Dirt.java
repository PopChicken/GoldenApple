
use pocketmine\item\Item;
use pocketmine\Player;

class Dirt extends Solid{

	public $isActivable = true;
	protected $hardness = 2.5;
	protected $id = self::DIRT;
	protected $meta = 0;
	protected $name = "Dirt";

	public function __construct(){

	}

	public function onActivate(Item $item, Player $player = null){
		if($item->isHoe()){
			$item->useOn($this);
			$this->getLevel()->setBlock($this, Block::get(Item::FARMLAND, 0), true);

			return true;
		}

		return false;
	}
}