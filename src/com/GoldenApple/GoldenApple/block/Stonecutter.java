
use pocketmine\item\Item;
use pocketmine\Player;

//TODO: check orientation
class Stonecutter extends Solid{
	public function __construct($meta = 0){
		parent::__construct(self::STONECUTTER, $meta, "Stonecutter");
		$this->isActivable = true;
	}

	public function onActivate(Item $item, Player $player = null){
		if($player instanceof Player){
			$player->craftingType = 2;
		}

		return true;
	}

	public function getDrops(Item $item){
		return [
			[$this->id, 0, 1],
		];
	}
}