
use pocketmine\item\Item;
use pocketmine\level\generator\object\TallGrass as TallGrassObject;
use pocketmine\level\Level;
use pocketmine\level\Position;
use pocketmine\Player;
use pocketmine\utils\Random;

class Grass extends Solid{

	public $isActivable = true;
	protected $hardness = 3;
	protected $id = self::GRASS;
	protected $meta = 0;
	protected $name = "Grass";

	public function __construct(){

	}

	public function getDrops(Item $item){
		return [
			[Item::DIRT, 0, 1],
		];
	}

	public function onUpdate($type){
		if($type === Level::BLOCK_UPDATE_RANDOM){
			//TODO: light levels
			$x = mt_rand($this->x - 1, $this->x + 1);
			$y = mt_rand($this->y - 2, $this->y + 2);
			$z = mt_rand($this->z - 1, $this->z + 1);
			$block = $this->getLevel()->getBlockIdAt($x, $y, $z);
			if($block === Block::DIRT){
				$block = Block::get($block, $this->getLevel()->getBlockDataAt($x, $y, $z), new Position($x, $y, $z, $this->getLevel()));
				if($block->getSide(1) instanceof Transparent){
					$this->getLevel()->setBlock($block, new Grass());
				}
			}
		}
	}

	public function onActivate(Item $item, Player $player = null){
		if($item->getID() === Item::DYE and $item->getDamage() === 0x0F){
			$item->count--;
			TallGrassObject::growGrass($this->getLevel(), $this, new Random(mt_rand()), 8, 2);

			return true;
		}elseif($item->isHoe()){
			$item->useOn($this);
			$this->getLevel()->setBlock($this, new Farmland());

			return true;
		}

		return false;
	}
}