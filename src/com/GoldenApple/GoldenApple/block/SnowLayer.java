
use pocketmine\item\Item;
use pocketmine\level\Level;
use pocketmine\Player;

class SnowLayer extends Flowable{
	public function __construct($meta = 0){
		parent::__construct(self::SNOW_LAYER, $meta, "Snow Layer");
		$this->isReplaceable = true;
		$this->isSolid = false;
		$this->isFullBlock = false;
		$this->hardness = 0.5;
	}

	public function getBoundingBox(){
		return null;
	}


	public function place(Item $item, Block $block, Block $target, $face, $fx, $fy, $fz, Player $player = null){
		$down = $this->getSide(0);
		if($down instanceof Solid){
			$this->getLevel()->setBlock($block, $this, true);

			return true;
		}

		return false;
	}

	public function onUpdate($type){
		if($type === Level::BLOCK_UPDATE_NORMAL){
			if($this->getSide(0)->getID() === self::AIR){ //Replace with common break method
				$this->getLevel()->setBlock($this, new Air(), true);

				return Level::BLOCK_UPDATE_NORMAL;
			}
		}

		return false;
	}

	public function getDrops(Item $item){
		if($item->isShovel() !== false){
			return [
				[Item::SNOWBALL, 0, 1],
			];
		}

		return [];
	}
}